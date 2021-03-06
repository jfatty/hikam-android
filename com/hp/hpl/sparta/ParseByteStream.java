package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.commons.compress.utils.CharsetNames;

class ParseByteStream implements ParseSource {
    private ParseCharStream parseSource_;

    public ParseByteStream(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        String str3;
        ParseLog parseLog2 = parseLog == null ? ParseSource.DEFAULT_LOG : parseLog;
        if (inputStream.markSupported()) {
            inputStream.mark(ParseSource.MAXLOOKAHEAD);
            byte[] bArr = new byte[4];
            String guessEncoding = str2 == null ? guessEncoding(str, bArr, inputStream.read(bArr), parseLog2) : str2;
            try {
                inputStream.reset();
                try {
                    this.parseSource_ = new ParseCharStream(str, new InputStreamReader(inputStream, fixEncoding(guessEncoding)), parseLog2, guessEncoding, parseHandler);
                    return;
                } catch (IOException e) {
                    str3 = "euc-jp";
                    parseLog2.note(new StringBuffer().append("Problem reading with assumed encoding of ").append(guessEncoding).append(" so restarting with ").append(str3).toString(), str, 1);
                    inputStream.reset();
                    this.parseSource_ = new ParseCharStream(str, new InputStreamReader(inputStream, fixEncoding(str3)), parseLog2, null, parseHandler);
                    return;
                }
            } catch (UnsupportedEncodingException e2) {
                throw new ParseException(parseLog2, str, 1, 0, str3, new StringBuffer().append("\"").append(str3).append("\" is not a supported encoding").toString());
            } catch (EncodingMismatchException e3) {
                String declaredEncoding = e3.getDeclaredEncoding();
                parseLog2.note(new StringBuffer().append("Encoding declaration of ").append(declaredEncoding).append(" is different that assumed ").append(guessEncoding).append(" so restarting the parsing with the new encoding").toString(), str, 1);
                inputStream.reset();
                try {
                    this.parseSource_ = new ParseCharStream(str, new InputStreamReader(inputStream, fixEncoding(declaredEncoding)), parseLog2, null, parseHandler);
                    return;
                } catch (UnsupportedEncodingException e4) {
                    throw new ParseException(parseLog2, str, 1, 0, declaredEncoding, new StringBuffer().append("\"").append(declaredEncoding).append("\" is not a supported encoding").toString());
                }
            }
        }
        throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
    }

    private static boolean equals(byte[] bArr, int i) {
        return bArr[0] == ((byte) (i >>> 24)) && bArr[1] == ((byte) ((i >>> 16) & 255)) && bArr[2] == ((byte) ((i >>> 8) & 255)) && bArr[3] == ((byte) (i & 255));
    }

    private static boolean equals(byte[] bArr, short s) {
        return bArr[0] == ((byte) (s >>> 8)) && bArr[1] == ((byte) (s & 255));
    }

    private static String fixEncoding(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }

    private static String guessEncoding(String str, byte[] bArr, int i, ParseLog parseLog) throws IOException {
        String str2;
        if (i != 4) {
            parseLog.error(i <= 0 ? "no characters in input" : new StringBuffer().append("less than 4 characters in input: \"").append(new String(bArr, 0, i)).append("\"").toString(), str, 1);
            str2 = "UTF-8";
        } else {
            str2 = (equals(bArr, 65279) || equals(bArr, -131072) || equals(bArr, 65534) || equals(bArr, -16842752) || equals(bArr, 60) || equals(bArr, 1006632960) || equals(bArr, 15360) || equals(bArr, 3932160)) ? "UCS-4" : equals(bArr, 3932223) ? CharsetNames.UTF_16BE : equals(bArr, 1006649088) ? CharsetNames.UTF_16LE : equals(bArr, 1010792557) ? "UTF-8" : equals(bArr, 1282385812) ? "EBCDIC" : (equals(bArr, (short) -2) || equals(bArr, (short) -257)) ? "UTF-16" : "UTF-8";
        }
        if (!str2.equals("UTF-8")) {
            parseLog.note(new StringBuffer().append("From start ").append(hex(bArr[0])).append(" ").append(hex(bArr[1])).append(" ").append(hex(bArr[2])).append(" ").append(hex(bArr[3])).append(" deduced encoding = ").append(str2).toString(), str, 1);
        }
        return str2;
    }

    private static String hex(byte b) {
        String toHexString = Integer.toHexString(b);
        switch (toHexString.length()) {
            case 1:
                return new StringBuffer().append("0").append(toHexString).toString();
            case 2:
                return toHexString;
            default:
                return toHexString.substring(toHexString.length() - 2);
        }
    }

    public int getLineNumber() {
        return this.parseSource_.getLineNumber();
    }

    public String getSystemId() {
        return this.parseSource_.getSystemId();
    }

    public String toString() {
        return this.parseSource_.toString();
    }
}
