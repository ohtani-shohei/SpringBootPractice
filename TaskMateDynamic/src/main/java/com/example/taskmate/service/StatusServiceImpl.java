package com.example.taskmate.service;

import java.util.List;

import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import com.example.taskmate.entity.StatusRecord;
import com.example.taskmate.entity.support.StatusDynamicSqlSupport;
import com.example.taskmate.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	
	private final StatusRepository statusRepository;

//	@Autowired
	public StatusServiceImpl(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	@Override
	public List<StatusRecord> findAll() {
		SelectStatementProvider select = SqlBuilder
				.select(StatusDynamicSqlSupport.statusCode, StatusDynamicSqlSupport.statusName)
				.from(StatusDynamicSqlSupport.status)
				.orderBy(StatusDynamicSqlSupport.statusCode)
				.build()
				.render(RenderingStrategies.MYBATIS3);
		List<StatusRecord> list = statusRepository.select(select);
		return list;
	}

	@Override
	public StatusRecord findByCode(String statusCode) {
		SelectStatementProvider select = SqlBuilder
				.select(StatusDynamicSqlSupport.statusCode, StatusDynamicSqlSupport.statusName)
				.from(StatusDynamicSqlSupport.status)
				.where(StatusDynamicSqlSupport.statusCode, SqlBuilder.isEqualTo(statusCode))
				.orderBy(StatusDynamicSqlSupport.statusCode)
				.build()
				.render(RenderingStrategies.MYBATIS3);
		StatusRecord status = statusRepository.select(select).stream().findFirst().get();
		
		return status;
	}

}
