package org.mipams.jumbf.demo.services.privacy_security;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BmffBox;
import org.mipams.jumbf.util.MipamsException;

import org.mipams.jumbf.demo.services.ContentTypeParser;
import org.mipams.jumbf.demo.services.privacy_security.replacement.DataBoxParser;
import org.mipams.jumbf.demo.services.privacy_security.replacement.DataBoxParserFactory;

import org.mipams.privsec.entities.ReplacementDescriptionBox;
import org.mipams.privsec.entities.replacement.ReplacementType;
import org.mipams.privsec.services.content_types.ReplacementContentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplacementBoxParser implements ContentTypeParser {

    @Autowired
    ReplacementContentType replacementContentType;

    @Autowired
    ReplacementDescriptionBoxParser replacementDescriptionBoxParser;

    @Autowired
    DataBoxParserFactory dataBoxParserFactory;

    @Override
    public List<BmffBox> discoverContentBoxesFromRequest(ObjectNode inputNode) throws MipamsException {
        ObjectNode replacementDescriptionNode = (ObjectNode) inputNode.get("replacementDescription");
        ReplacementDescriptionBox replacementDescriptionBox = replacementDescriptionBoxParser
                .discoverBoxFromRequest(replacementDescriptionNode);

        ReplacementType replacementType = getReplacementType(replacementDescriptionBox);
        DataBoxParser dataBoxParser = dataBoxParserFactory.getDataBoxParserFromType(replacementType);

        List<BmffBox> replacementDataBoxList = dataBoxParser.discoverDataBoxFromRequest(inputNode);

        List<BmffBox> contentBoxList = new ArrayList<>();
        contentBoxList.add(replacementDescriptionBox);
        contentBoxList.addAll(replacementDataBoxList);

        return contentBoxList;
    }

    @Override
    public String getContentTypeUuid() {
        return replacementContentType.getContentTypeUuid();
    }

    ReplacementType getReplacementType(ReplacementDescriptionBox replacementDescriptionBox) throws MipamsException {
        return ReplacementType
                .getTypeFromId(replacementDescriptionBox.getReplacementTypeId());
    }

}
