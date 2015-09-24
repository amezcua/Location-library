package net.byteabyte.location.gps;

import java.io.Serializable;

public abstract class GpsSentenceBase implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String sentenceInstance = "";
	private String inferredSentenceName = "";
	private String inferredTalkerID = "";
	private String inferredSentenceID = "";
	private String sentenceName = "";
	private String description = "";
	private int wordCount = -1;
	private String checkSum = "";
	private String[] words;
	

	public GpsSentenceBase(String SentenceInstance)
	{
		sentenceInstance = SentenceInstance;

		String[] checksumSplit = SentenceInstance.split("\\*");

		// TODO: If checksumSplit.Length > 2 -> Error
		checkSum = checksumSplit[1];

		words = checksumSplit[0].split(",");
		wordCount = words.length;

		inferredTalkerID = words[0].substring(1, 3);
		inferredSentenceName = words[0].substring(3, 6);
	}
	
	public String getSentenceInstance(){ return sentenceInstance; }
	public void setSentenceInstance(String value){ sentenceInstance = value; }

	public String getSentenceName()	{ return sentenceName;	}
	public void setSentenceName(String value){ sentenceName = value; }
	
	public String getDescription() { return description; }
	public void setDescription(String value) { description = value; }
	
	protected String[] getWords() { return words; }
	
	public int getWordCount() { return wordCount; }

	public String getCheckSum() { return checkSum; }
	
	public String getInferredSentenceName() { return inferredSentenceName; }
	public void setInferredSentenceName(String value) { inferredSentenceName = value; }
	
	public String getInferredSentenceID() { return inferredSentenceID; }
	public void setInferredSentenceID(String value) { inferredSentenceID = value; }
	
	public String getInferredTalkerID() { return inferredTalkerID; }
	public void setInferredTalkerID(String value) { inferredTalkerID = value; }
	
	public boolean validCheckSum() {
		return getCheckSum().equalsIgnoreCase(checkSum);
	}
}