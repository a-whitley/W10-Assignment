package entity;

public class Instrument {
	
	private int id;
	private String name;
	private String type;
	private String origin;
	
	public Instrument(int id, String name, String type, String origin) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setOrigin(origin);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
