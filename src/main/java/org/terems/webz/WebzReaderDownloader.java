package org.terems.webz;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/** TODO !!! describe !!! **/
public interface WebzReaderDownloader extends WebzFileSpecificDownloader {

	/** TODO !!! describe !!! **/
	public String getActualEncoding();

	/** TODO !!! describe !!! **/
	public long getActualNumberOfBytes();

	/** TODO !!! describe !!! **/
	public Reader getReader() throws IOException;

	/** TODO !!! describe !!! **/
	public long copyContentAndClose(OutputStream out) throws WebzReadException, WebzWriteException, IOException;

	/** TODO !!! describe !!! **/
	public long copyContentAndClose(Writer writer) throws WebzReadException, WebzWriteException, IOException;

	/** TODO !!! describe !!! **/
	public String getContentAsStringAndClose() throws WebzReadException, WebzWriteException, IOException;

}
