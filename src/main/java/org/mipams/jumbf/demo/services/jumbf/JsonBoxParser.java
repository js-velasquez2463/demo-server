package org.mipams.jumbf.demo.services.jumbf;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BmffBox;
import org.mipams.jumbf.entities.JsonBox;
import org.mipams.jumbf.services.content_types.JsonContentType;
import org.mipams.jumbf.util.MipamsException;

import org.mipams.jumbf.demo.services.ContentTypeParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonBoxParser extends MemoryBoxParser<JsonBox> implements ContentTypeParser {

    @Autowired
    JsonContentType jsonContentType;

    @Override
    protected JsonBox initializeBox() {
        return new JsonBox();
    }

    @Override
    public List<BmffBox> discoverContentBoxesFromRequest(ObjectNode input) throws MipamsException {
        return List.of(discoverBoxFromRequest(input));
    }

    @Override
    public String getContentTypeUuid() {
        return jsonContentType.getContentTypeUuid();
    }
}
