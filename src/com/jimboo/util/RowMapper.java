package com.jimboo.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
	T getInstance(ResultSet rs) throws SQLException;
}
