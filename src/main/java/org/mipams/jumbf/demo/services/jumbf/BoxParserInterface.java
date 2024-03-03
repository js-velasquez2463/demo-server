package org.mipams.jumbf.demo.services.jumbf;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.entities.BoxInterface;
import org.mipams.jumbf.util.MipamsException;

public interface BoxParserInterface {

    public BoxInterface discoverBoxFromRequest(ObjectNode inputNode) throws MipamsException;
}
