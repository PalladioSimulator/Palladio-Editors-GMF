/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.ui.URIEditorInput;

/**
 * @generated
 */
public class PalladioComponentModelUriEditorInputTester extends PropertyTester {

    /**
     * @generated
     */
    public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
        if (false == receiver instanceof URIEditorInput) {
            return false;
        }
        URIEditorInput editorInput = (URIEditorInput) receiver;
        return "repository_diagram".equals(editorInput.getURI().fileExtension()); //$NON-NLS-1$
    }

}
