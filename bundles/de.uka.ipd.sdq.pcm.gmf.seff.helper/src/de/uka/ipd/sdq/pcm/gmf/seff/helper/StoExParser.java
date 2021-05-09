package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser;

import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * The Class StoExParser.
 */
public class StoExParser implements IParser {

    protected static final org.palladiosimulator.pcm.stoex.api.StoExParser STOEX_PARSER = org.palladiosimulator.pcm.stoex.api.StoExParser.createInstance();
    protected static final StoExSerialiser STOEX_SERIALISER = StoExSerialiser.createInstance();
    
    /**
     * Gets the completion processor.
     * 
     * @param element
     *            the element
     * @return the completion processor
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
     * @deprecated This method only returns a dummy {@link IContentAssistProcessor} that does not
     *             provide any useful information when called. Clients should switch to Xtext-based
     *             editors.
     */
    @Override
    @Deprecated
    public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
        return new IContentAssistProcessor() {

            @Override
            public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
                return new ICompletionProposal[0];
            }

            @Override
            public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
                return new IContextInformation[0];
            }

            @Override
            public char[] getCompletionProposalAutoActivationCharacters() {
                return new char[0];
            }

            @Override
            public char[] getContextInformationAutoActivationCharacters() {
                return new char[0];
            }

            @Override
            public String getErrorMessage() {
                return null;
            }

            @Override
            public IContextInformationValidator getContextInformationValidator() {
                return null;
            }
            
        };
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getEditString(org.eclipse.core.
     * runtime.IAdaptable, int)
     */
    /**
     * Gets the edits the string.
     * 
     * @param element
     *            the element
     * @param flags
     *            the flags
     * @return the edits the string
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getEditString(org.eclipse.core.runtime.IAdaptable,
     *      int)
     */
    @Override
    public String getEditString(final IAdaptable element, final int flags) {
        final RandomVariable randomVariable = (RandomVariable) element.getAdapter(RandomVariable.class);
        return randomVariable.getSpecification();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getParseCommand(org.eclipse.core
     * .runtime.IAdaptable, java.lang.String, int)
     */
    /**
     * Gets the parses the command.
     * 
     * @param element
     *            the element
     * @param newString
     *            the new string
     * @param flags
     *            the flags
     * @return the parses the command
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getParseCommand(org.eclipse.core.runtime.IAdaptable,
     *      java.lang.String, int)
     */
    @Override
    public ICommand getParseCommand(final IAdaptable element, final String newString, final int flags) {
        final SetRequest req = new SetRequest((EObject) element.getAdapter(RandomVariable.class),
                StoexPackage.eINSTANCE.getRandomVariable_Specification(), newString);
        final SetValueCommand cmd = new SetValueCommand(req);
        return cmd;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getPrintString(org.eclipse.core
     * .runtime.IAdaptable, int)
     */
    /**
     * Gets the prints the string.
     * 
     * @param element
     *            the element
     * @param flags
     *            the flags
     * @return the prints the string
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getPrintString(org.eclipse.core.runtime.IAdaptable,
     *      int)
     */
    @Override
    public String getPrintString(final IAdaptable element, final int flags) {
        final RandomVariable randomVariable = (RandomVariable) element.getAdapter(RandomVariable.class);
        Expression expr;
        try {
            expr = STOEX_PARSER.parse(randomVariable.getSpecification());
            final String result = STOEX_SERIALISER.serialise(expr);
            return result;
        } catch (final Exception e) {
            return "<invalid StoEx>";
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isAffectingEvent(java.lang.Object,
     * int)
     */
    /**
     * Checks if is affecting event.
     * 
     * @param event
     *            the event
     * @param flags
     *            the flags
     * @return true, if is affecting event
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isAffectingEvent(java.lang.Object,
     *      int)
     */
    @Override
    public boolean isAffectingEvent(final Object event, final int flags) {
        return true;
    }

    // FIXME: Testing via exceptions is really bad style!
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isValidEditString(org.eclipse.core
     * .runtime.IAdaptable, java.lang.String)
     */
    /**
     * Checks if is valid edit string.
     * 
     * @param element
     *            the element
     * @param editString
     *            the edit string
     * @return the i parser edit status
     * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isValidEditString(org.eclipse.core.runtime.IAdaptable,
     *      java.lang.String)
     */
    @Override
    public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
        try {
            STOEX_PARSER.parse(editString);
            return new ParserEditStatus("de.uka.ipd.sdq.pcm.gmf.seff.helper", IParserEditStatus.EDITABLE, "");
        } catch (final Exception e) {
            return new ParserEditStatus(IStatus.ERROR, "de.uka.ipd.sdq.pcm.gmf.seff.helper",
                    IParserEditStatus.EDITABLE, "", e);
        }
    }

}
