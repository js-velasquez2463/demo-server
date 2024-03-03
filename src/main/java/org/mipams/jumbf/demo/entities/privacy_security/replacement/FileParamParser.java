package org.mipams.jumbf.demo.entities.privacy_security.replacement;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.mipams.jumbf.util.MipamsException;
import org.mipams.privsec.entities.replacement.FileParamHandler;
import org.mipams.privsec.entities.replacement.ParamHandlerInterface;

public class FileParamParser implements ParamParserInterface {

    public ParamHandlerInterface populateParamFromRequest(ObjectNode input) throws MipamsException {
        return new FileParamHandler();
    }
}
