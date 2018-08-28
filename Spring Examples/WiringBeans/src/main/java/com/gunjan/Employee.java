package com.gunjan;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

public class Employee implements BeanNameAware, DisposableBean,
BeanPostProcessor, InitializingBean, ApplicationListener<HolidayEvent>,ApplicationContextAware {

	public Employee(int empId, String cubicalNumber, String position) {
		super();
		this.empId = empId;
		this.cubicalNumber = cubicalNumber;
		this.position = position;
	}

	private int empId;
	private String cubicalNumber;
	private String position;
	private String name;
	private int age;
	private String beanName;
	private BeanFactory beanFactory;
	private InnerBean innerBean;
	private List<String> skill;
	private String[] manager;
	private Set<String> emailAddress;
	private Map<String, Integer> daysHourMap;
	private Properties employeeProps;
	private String lastName = "Kumar";
	private Properties employeePropsFrmFile;
	private PhoneNumber phoneNumber;
	private ApplicationContext applicationContext;

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Properties getEmployeePropsFrmFile() {
		return employeePropsFrmFile;
	}

	public void setEmployeePropsFrmFile(Properties employeePropsFrmFile) {
		this.employeePropsFrmFile = employeePropsFrmFile;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Properties getEmployeeProps() {
		return employeeProps;
	}

	public void setEmployeeProps(Properties employeeProps) {
		this.employeeProps = employeeProps;
	}

	public Set<String> getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(Set<String> emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Map<String, Integer> getDaysHourMap() {
		return daysHourMap;
	}

	public void setDaysHourMap(Map<String, Integer> daysHourMap) {
		this.daysHourMap = daysHourMap;
	}

	public String[] getManager() {
		return manager;
	}

	public void setManager(String[] manager) {
		this.manager = manager;
	}

	public List<String> getSkill() {
		return skill;
	}

	public void setSkill(List<String> skill) {
		this.skill = skill;
	}

	public InnerBean getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(InnerBean innerBean) {
		this.innerBean = innerBean;
	}

	public void setup() {
		System.out.println("setup");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void setBeanName(String arg0) {
		this.beanName = arg0;
	}

	public String getBeanName() {
		return beanName;
	}

	public void teardown() {
	}

	@Override
	public void destroy() throws Exception {
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [empId=");
		builder.append(empId);
		builder.append(", cubicalNumber=");
		builder.append(cubicalNumber);
		builder.append(", position=");
		builder.append(position);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", beanName=");
		builder.append(beanName);
		builder.append(", beanFactory=");
		builder.append(beanFactory);
		builder.append(", innerBean=");
		builder.append(innerBean);
		builder.append(", skill=");
		builder.append(skill);
		builder.append(", manager=");
		builder.append(Arrays.toString(manager));
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", daysHourMap=");
		builder.append(daysHourMap);
		builder.append(", employeeProps=");
		builder.append(employeeProps);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", employeePropsFrmFile=");
		builder.append(employeePropsFrmFile);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String name)
			throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.getType().equals(java.lang.String.class)) {
				field.setAccessible(true);
				try {
					field.set(bean, field.get(bean) + "_Str");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}

		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name)
			throws BeansException {
		return bean;
	}

	@Override
	public void onApplicationEvent(HolidayEvent arg0) {
		System.out.println(arg0.holidayReason());
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.applicationContext = context;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
