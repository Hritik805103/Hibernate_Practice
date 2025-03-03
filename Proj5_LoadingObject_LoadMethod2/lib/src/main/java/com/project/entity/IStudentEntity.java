package com.project.entity;

//This can also be called ad Proxy interface because it will create the proxy class based on this IStudentEntity Interface
public interface IStudentEntity {

	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public String getCourse();
	public void setCourse(String course);
	public String getEmail();
	public void setEmail(String email);	
}
