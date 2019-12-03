package com.example.demo;

public class JavaClass {
	private Long id;
	private SomeEnum someEnum;

	public JavaClass() {
	}

	public JavaClass(SomeEnum _someEnum) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SomeEnum getSomeEnum() {
		return someEnum;
	}

	public void setSomeEnum(SomeEnum someEnum) {
		this.someEnum = someEnum;
	}
}
