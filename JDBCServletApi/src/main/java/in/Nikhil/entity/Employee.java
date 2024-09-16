package in.Nikhil.entity;

public class Employee 
{
	private Integer eid;
	private String ename;
	private Integer eage;
	private String eadress;
	
	public Integer getEid()
	{
		return eid;
		
	}
	public void setEid(Integer eid)
	{
		this.eid=eid;
		
	}
	public String getEname()
	{
		return ename;
	}
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	public Integer getEage()
	{
		return eage;
		
	}
	public void setEage(Integer eage)
	{
		this.eage=eage;
	}
	public String getEadress()
	{
		return eadress;
	}
	public void setEadress(String eadress)
	{
		this.eadress=eadress;
	}
	@Override
	public String toString() {
		
		return "Employee [eid="+eid+",ename="+ename+",eage="+eage+",eadress="+eadress;
	}
}
