package de.dfki.asr.ajan.behaviour.service.impl;

import de.dfki.asr.ajan.behaviour.exception.MessageEvaluationException;
import de.dfki.asr.ajan.behaviour.nodes.action.common.ACTNVocabulary;
import de.dfki.asr.ajan.behaviour.nodes.query.BehaviorSelectQuery;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.cyberborean.rdfbeans.annotations.RDF;
import org.cyberborean.rdfbeans.annotations.RDFBean;
import org.cyberborean.rdfbeans.annotations.RDFSubject;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.MalformedQueryException;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.http.HTTPQueryEvaluationException;

@RDFBean("http-core:Request")
public class HttpBinding {
	@RDFSubject
	@Getter @Setter
	private String url;

	@RDF("http-core:requestURI")
	@Getter @Setter
	private URI requestURI;

	@RDF("http-core:httpVersion")
	@Getter @Setter
	private String version;

	@RDF("http-core:mthd")
	@Getter @Setter
	private URI method;

	@RDF("http-core:headers")
	@Getter @Setter
	private List<HttpHeader> headers;

	@RDF("actn:headers")
	@Getter @Setter
	private String actnQuery;

	@RDF("bt:headers")
	@Getter @Setter
	private BehaviorSelectQuery btHeaders;

	@RDF("http-core:body")
	@Getter @Setter
	private ActnPayload payload;

	@SuppressWarnings("PMD.ConfusingTernary")
	public void setAddHeaders(final Repository repo) throws URISyntaxException, MessageEvaluationException {
		if (getActnQuery() == null && getBtHeaders() == null) {
			return;
		}
		List<HttpHeader> addHeaders = new ArrayList();
		if (getBtHeaders() != null) {
			addHeaders = getAdditionalHeaders(repo, getBtHeaders());
		} else if (getActnQuery() != null) {
			BehaviorSelectQuery actnHeaders = new BehaviorSelectQuery();
			actnHeaders.setSparql(getActnQuery());
			addHeaders = getAdditionalHeaders(repo, actnHeaders);
		}
		if (addHeaders.isEmpty()) {
			return;
		}
		addAddHeaders(addHeaders);
	}

	private List<HttpHeader> getAdditionalHeaders(final Repository repo, final BehaviorSelectQuery query) throws URISyntaxException, MessageEvaluationException {
		List<HttpHeader> addHeaders = new ArrayList();
		try {
			List<BindingSet> result = query.getResult(repo);
			if (result.isEmpty()) {
				return addHeaders;
			}
			Iterator<BindingSet> bindings = result.iterator();
			while (bindings.hasNext()) {
				BindingSet bindingSet = bindings.next();
				HttpHeader header = getHttpHeader(bindingSet);
				if (header != null) {
					addHeaders.add(header);
				}
			}
			return addHeaders;
		} catch (HTTPQueryEvaluationException | MalformedQueryException ex) {
			return addHeaders;
		}
	}

	private void addAddHeaders(final List<HttpHeader> addHeaders) {
		Iterator<HttpHeader> iterAdd = addHeaders.iterator();
		while (iterAdd.hasNext()) {
			HttpHeader add = iterAdd.next();
			boolean exists = false;
			Iterator<HttpHeader> iterOrig = getHeaders().iterator();
			while (iterOrig.hasNext()) {
				HttpHeader orig = iterOrig.next();
				String origFragment = orig.getHeaderName().getFragment();
				String addFragment = add.getHeaderName().getFragment();
				if (origFragment.equalsIgnoreCase(addFragment)) {
					exists = true;
				}
			}
			if (!exists) {
				getHeaders().add(add);
			}
		}
	}

	protected HttpHeader getHttpHeader(final BindingSet bindingSet) throws URISyntaxException {
		Value hdrName = bindingSet.getValue("hdrName");
		Value fieldValue = bindingSet.getValue("fieldValue");
		if (hdrName == null || fieldValue == null) {
			return null;
		}
		HttpHeader header = new HttpHeader();
		header.setHeaderName(new URI(ACTNVocabulary.DEFAULT.toString() + hdrName.stringValue()));
		header.setHeaderValue(fieldValue.stringValue());
		return header;
	}
}