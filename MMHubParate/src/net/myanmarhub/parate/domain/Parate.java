package net.myanmarhub.parate.domain;

import java.io.Serializable;

/**
 * 
 *  Copyright information
 * 
 * You may modify and reuse any parts of code or the whole project in 
 * your non-commercial app. However, you may not redistribute under 
 * Myanmar Hub's name or its alias. The resources used in this project are owned
 * properties of Myanmar Hub and will not be used to redistribute. Selling 
 * to use this source code is strongly prohibited.
 *
 * @author Tin Htoo Aung (Myanmar Hub)
 *
 */

public class Parate implements Serializable{

	/**
	 * Default SerailVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String content;
	private String mp3Path;
	
	public static final String TB_NAME = "name";
	public static final String TABLE = "parate";
	public static final String TB_CONTENT = "content";
	public static final String TB_MP3PATH = "mp3Path";
	public static final String ID = "_id";
	
	public Parate() {}

	public String getMp3Path() {
		return mp3Path;
	}
	
	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Parate [id=" + id + ", name=" + name + ", content=" + content
				+ "]";
	}
	
	

}
