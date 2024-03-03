package org.mipams.jumbf.demo.services.jumbf;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BinaryDataBox;
import org.mipams.jumbf.entities.BmffBox;
import org.mipams.jumbf.entities.EmbeddedFileDescriptionBox;
import org.mipams.jumbf.services.content_types.EmbeddedFileContentType;
import org.mipams.jumbf.util.MipamsException;

import org.mipams.jumbf.demo.services.ContentTypeParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmbeddedFileBoxParser implements ContentTypeParser {

    @Autowired
    EmbeddedFileContentType embeddedFileContentType;

    @Autowired
    EmbeddedFileDescriptionBoxParser embeddedFileDescriptionBoxParser;

    @Autowired
    BinaryDataBoxParser binaryDataBoxParser;

    @Override
    public List<BmffBox> discoverContentBoxesFromRequest(ObjectNode inputNode) throws MipamsException {

        ObjectNode descriptionNode = (ObjectNode) inputNode.get("embeddedFileDescription");
        EmbeddedFileDescriptionBox embeddedFileDescriptionBox = embeddedFileDescriptionBoxParser
                .discoverBoxFromRequest(descriptionNode);

        ObjectNode binaryDataNode = (ObjectNode) inputNode.get("content");
        BinaryDataBox binaryDataBox = binaryDataBoxParser.discoverBoxFromRequest(binaryDataNode);

        binaryDataBox.setReferencedExternally(embeddedFileDescriptionBox.isContentReferencedExternally());
        binaryDataBox.updateFieldsBasedOnExistingData();

        return List.of(embeddedFileDescriptionBox, binaryDataBox);
    }

    @Override
    public String getContentTypeUuid() {
        return embeddedFileContentType.getContentTypeUuid();
    }

}
