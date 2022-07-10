package com.demo.nasapicturesapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class NasaResponse implements Serializable {

	@SerializedName("date")
	private String date;

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("media_type")
	private String mediaType;

	@SerializedName("hdurl")
	private String hdurl;

	@SerializedName("service_version")
	private String serviceVersion;

	@SerializedName("explanation")
	private String explanation;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	public String getDate(){
		return date;
	}

	public String getCopyright(){
		return copyright;
	}

	public String getMediaType(){
		return mediaType;
	}

	public String getHdurl(){
		return hdurl;
	}

	public String getServiceVersion(){
		return serviceVersion;
	}

	public String getExplanation(){
		return explanation;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NasaResponse that = (NasaResponse) o;
		return Objects.equals(date, that.date) && Objects.equals(copyright, that.copyright) && Objects.equals(mediaType, that.mediaType) && Objects.equals(hdurl, that.hdurl) && Objects.equals(serviceVersion, that.serviceVersion) && Objects.equals(explanation, that.explanation) && Objects.equals(title, that.title) && Objects.equals(url, that.url);
	}
}