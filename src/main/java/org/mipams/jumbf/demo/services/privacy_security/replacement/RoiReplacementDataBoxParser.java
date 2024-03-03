package org.mipams.jumbf.demo.services.privacy_security.replacement;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BmffBox;
import org.mipams.jumbf.entities.ContiguousCodestreamBox;
import org.mipams.jumbf.util.MipamsException;
import org.mipams.jumbf.demo.services.jumbf.ContiguousCodestreamBoxParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoiReplacementDataBoxParser implements DataBoxParser {

    @Autowired
    ContiguousCodestreamBoxParser contiguousCodestreamBoxParser;

    @Override
    public List<BmffBox> discoverDataBoxFromRequest(ObjectNode inputNode) throws MipamsException {

        ObjectNode contentNode = (ObjectNode) inputNode.get("content");

        ContiguousCodestreamBox contiguousCodestreamBox = contiguousCodestreamBoxParser
                .discoverBoxFromRequest(contentNode);

        return List.of(contiguousCodestreamBox);
    }
}
