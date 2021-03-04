package eu.lundegaard.testform.testData;

import eu.lundegaard.testform.domain.RequestKind;

import java.util.List;

public final class RequestKindTestData {

    private static final RequestKind TEST_REQUEST_KIND = new RequestKind()
            .setId(3L)
            .setKindOfRequest("Complaint");

    private static final Iterable<RequestKind> REQUEST_KINDS = List.of(
            new RequestKind()
                    .setId(1L)
                    .setKindOfRequest("Contract Adjustment"),
            new RequestKind()
                    .setId(2L)
                    .setKindOfRequest("Damage Case"),
            new RequestKind()
                    .setId(3L)
                    .setKindOfRequest("Complaint")
    );

    private RequestKindTestData() {
    }

    public static RequestKind getTestRequestKind() {
        return TEST_REQUEST_KIND;
    }

    public static Iterable<RequestKind> getRequestKinds() {
        return REQUEST_KINDS;
    }
}
