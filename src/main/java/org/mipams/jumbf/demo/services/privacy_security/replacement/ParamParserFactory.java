package org.mipams.jumbf.demo.services.privacy_security.replacement;

import org.mipams.jumbf.util.MipamsException;
import org.mipams.jumbf.demo.entities.privacy_security.replacement.AppParamParser;
import org.mipams.jumbf.demo.entities.privacy_security.replacement.BoxParamParser;
import org.mipams.jumbf.demo.entities.privacy_security.replacement.FileParamParser;
import org.mipams.jumbf.demo.entities.privacy_security.replacement.ParamParserInterface;
import org.mipams.jumbf.demo.entities.privacy_security.replacement.RoiParamParser;
import org.mipams.privsec.entities.replacement.ReplacementType;
import org.springframework.stereotype.Component;

@Component
public class ParamParserFactory {
    public ParamParserInterface getParamParser(ReplacementType replacementType) throws MipamsException {

        ParamParserInterface result = null;

        switch (replacementType) {
            case BOX:
                result = new BoxParamParser();
                break;
            case APP:
                result = new AppParamParser();
                break;
            case ROI:
                result = new RoiParamParser();
                break;
            case FILE:
                result = new FileParamParser();
                break;
            default:
                throw new MipamsException();
        }

        return result;
    }
}
