package org.mipams.jumbf.demo.services.jumbf;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.XmlBox;
import org.mipams.jumbf.services.content_types.XmlContentType;
import org.mipams.jumbf.util.MipamsException;
import org.mipams.jumbf.entities.BmffBox;

import org.mipams.jumbf.demo.services.ContentTypeParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XmlBoxParser extends MemoryBoxParser<XmlBox> implements ContentTypeParser {

    @Autowired
    XmlContentType xmlContentType;

    @Override
    protected XmlBox initializeBox() {
        return new XmlBox();
    }

    @Override
    public List<BmffBox> discoverContentBoxesFromRequest(ObjectNode input) throws MipamsException {
        return List.of(discoverBoxFromRequest(input));
    }

    @Override
    public String getContentTypeUuid() {
        return xmlContentType.getContentTypeUuid();
    }
}
