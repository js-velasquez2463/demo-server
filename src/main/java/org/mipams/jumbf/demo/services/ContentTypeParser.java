package org.mipams.jumbf.demo.services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BmffBox;
import org.mipams.jumbf.util.MipamsException;

public interface ContentTypeParser {
    public List<BmffBox> discoverContentBoxesFromRequest(ObjectNode input) throws MipamsException;

    public String getContentTypeUuid();
}
