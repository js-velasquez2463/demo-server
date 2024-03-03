package org.mipams.jumbf.demo.services.jumbf;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BmffBox;
import org.mipams.jumbf.entities.ContiguousCodestreamBox;
import org.mipams.jumbf.services.content_types.ContiguousCodestreamContentType;
import org.mipams.jumbf.util.MipamsException;

import org.mipams.jumbf.demo.services.ContentTypeParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContiguousCodestreamBoxParser extends FileBoxParser<ContiguousCodestreamBox>
        implements ContentTypeParser {

    @Autowired
    ContiguousCodestreamContentType codestreamContentType;

    @Override
    protected ContiguousCodestreamBox initializeBox() {
        return new ContiguousCodestreamBox();
    }

    @Override
    public String getContentTypeUuid() {
        return codestreamContentType.getContentTypeUuid();
    }

    @Override
    public List<BmffBox> discoverContentBoxesFromRequest(ObjectNode input) throws MipamsException {
        return List.of(discoverBoxFromRequest(input));
    }
}
