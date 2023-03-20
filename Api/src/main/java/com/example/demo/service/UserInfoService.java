package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserInfoRepo;

@Service
public class UserInfoService {

	@Autowired
	UserInfoRepo uRepo;
	public UserInfo create(UserInfo userinfo) {
   	 return uRepo.save(userinfo);
    }
    public Optional<UserInfo> read(int id)
	{
		return uRepo.findById(id);
	}
	public UserInfo update(UserInfo userinfo)
	{
		return uRepo.save(userinfo);
	}
	public String delete (int id)
	{
		uRepo.deleteById(id);
		return "Deleted";
	}


}