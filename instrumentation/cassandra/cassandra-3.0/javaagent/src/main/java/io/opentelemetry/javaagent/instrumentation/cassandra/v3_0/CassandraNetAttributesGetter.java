/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.cassandra.v3_0;

import com.datastax.driver.core.ExecutionInfo;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import java.net.InetSocketAddress;
import javax.annotation.Nullable;

final class CassandraNetAttributesGetter
    implements NetClientAttributesGetter<CassandraRequest, ExecutionInfo> {

  @Nullable
  @Override
  public String getPeerName(CassandraRequest request) {
    return null;
  }

  @Nullable
  @Override
  public Integer getPeerPort(CassandraRequest request) {
    return null;
  }

  @Override
  @Nullable
  public InetSocketAddress getPeerSocketAddress(
      CassandraRequest request, @Nullable ExecutionInfo executionInfo) {
    return executionInfo == null ? null : executionInfo.getQueriedHost().getSocketAddress();
  }
}
