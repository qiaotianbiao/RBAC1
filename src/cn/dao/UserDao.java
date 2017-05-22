package cn.dao;

import cn.entity.User;

public interface UserDao {
	User searchUserByUsername(String username);
	int searchUseridByUsername(String username);
}
