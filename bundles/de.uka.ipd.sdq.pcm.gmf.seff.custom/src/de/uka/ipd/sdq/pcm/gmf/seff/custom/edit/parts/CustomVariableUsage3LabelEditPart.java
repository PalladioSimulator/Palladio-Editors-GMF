/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import java.io.NotSerializableException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser;

import de.uka.ipd.sdq.pcm.gmf.seff.custom.Activator;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3LabelEditPart;

/**
 * The customized variable usage3 label edit part classw.
 */
public class CustomVariableUsage3LabelEditPart extends VariableUsage3LabelEditPart {

    protected static final StoExSerialiser STOEX_SERIALISER = StoExSerialiser.createInstance();
    
    /**
     * Instantiates a new customized variable usage3 label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomVariableUsage3LabelEditPart(final View view) {
        super(view);
    }

    /**
     * Enhanced method to present the name of the VariableReference of the VariableUsage this
     * wrapping label edit part is about.
     * 
     * @return the label text
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final EObject parserElement = this.getParserElement();
        if (parserElement != null) {
            if (parserElement instanceof VariableUsage) {
                // customized
                final VariableUsage usage = (VariableUsage) this.resolveSemanticElement();
                if (usage.getNamedReference__VariableUsage() != null) {
                    try {
                        text = STOEX_SERIALISER.serialise(usage.getNamedReference__VariableUsage());
                    } catch (NotSerializableException e) {
                        Activator.getDefault().getLog().error("Could not serialise reference.", e);
                        text = null;
                    }
                }
            } else {
                if (parserElement != null && this.getParser() != null) {
                    text = this.getParser().getPrintString(new EObjectAdapter(parserElement),
                            this.getParserOptions().intValue());
                }
            }
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }

}
