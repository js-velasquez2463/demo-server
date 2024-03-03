package org.mipams.jumbf.demo.services.jumbf;

import org.mipams.jumbf.entities.BinaryDataBox;

import org.springframework.stereotype.Service;

@Service
public class BinaryDataBoxParser extends FileBoxParser<BinaryDataBox> {

    @Override
    protected BinaryDataBox initializeBox() {
        return new BinaryDataBox();
    }
}
