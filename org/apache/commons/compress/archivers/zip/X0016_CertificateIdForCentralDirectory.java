package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm;

public class X0016_CertificateIdForCentralDirectory extends PKWareExtraHeader {
    private HashAlgorithm hashAlg;
    private int rcount;

    public X0016_CertificateIdForCentralDirectory() {
        super(new ZipShort(22));
    }

    public int getRecordCount() {
        return this.rcount;
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlg;
    }

    public void parseFromCentralDirectoryData(byte[] data, int offset, int length) {
        this.rcount = ZipShort.getValue(data, offset);
        this.hashAlg = HashAlgorithm.getAlgorithmByCode(ZipShort.getValue(data, offset + 2));
    }
}
