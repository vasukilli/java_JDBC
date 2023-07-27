package com.Bitlabs.EmpDatabase;

public class Student 
{

		private int id;
		private String name;
		private String branch;
		
		public Student(int id, String name, String branch) {
			super();
			this.id = id;
			this.name = name;
			this.branch = branch;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", branch=" + branch + "]";
		}
		
		


}
