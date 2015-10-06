package com.shuzheng.ssm.interceptor;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import com.shuzheng.ssm.util.Paginator;

/**
 * 
 * 分页拦截器
 * @author shuzheng
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {

	private String pageSqlId;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 拦截的对象
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// 通过反射拿到拦截对象的sqlid
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
		// 配置文件中SQL语句的ID
		String id = mappedStatement.getId();
		// 如果SQL的ID符合我们的过滤正则表达式
		if (id.matches(pageSqlId)) {
			BoundSql boundSql = statementHandler.getBoundSql();
			// 原始的SQL语句
			String sql = boundSql.getSql();
			Map<?, ?> parameter = (Map<?, ?>) boundSql.getParameterObject();
			Paginator paginator = (Paginator) parameter.get("paginator");
			// 改造后带分页查询的SQL语句
			String pageSql = sql + " limit " + (paginator.getPage() - 1) * paginator.getRows() + "," + paginator.getRows();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// 拦截的对象是否需要代理，如果是则执行intercept方法增强，不是则直接放行
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// 初始化拦截器的配置
		this.pageSqlId = properties.getProperty("pageSqlId");
	}

}
