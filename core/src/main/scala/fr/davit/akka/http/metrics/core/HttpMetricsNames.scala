/*
 * Copyright 2019 Michel Davit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.davit.akka.http.metrics.core

import com.typesafe.config.Config

trait HttpMetricsNames {
  def requests: String
  def requestsActive: String
  def requestsSize: String
  def responses: String
  def responsesErrors: String
  def responsesDuration: String
  def responsesSize: String
  def connections: String
  def connectionsActive: String

  def withRequests(name: String): HttpMetricsNames
  def withRequestsActive(name: String): HttpMetricsNames
  def withRequestSize(name: String): HttpMetricsNames
  def withResponses(name: String): HttpMetricsNames
  def withResponsesErrors(name: String): HttpMetricsNames
  def withResponsesDuration(name: String): HttpMetricsNames
  def withResponseSize(name: String): HttpMetricsNames
  def withConnections(name: String): HttpMetricsNames
  def withConnectionsActive(name: String): HttpMetricsNames

}

object HttpMetricsNames {

  private[metrics] case class HttpMetricsNamesImpl(
      requests: String,
      requestsActive: String,
      requestsSize: String,
      responses: String,
      responsesErrors: String,
      responsesDuration: String,
      responsesSize: String,
      connections: String,
      connectionsActive: String
  ) extends HttpMetricsNames {
    def withRequests(name: String): HttpMetricsNamesImpl          = copy(requests = name)
    def withRequestsActive(name: String): HttpMetricsNamesImpl    = copy(requestsActive = name)
    def withRequestSize(name: String): HttpMetricsNamesImpl       = copy(requestsSize = name)
    def withResponses(name: String): HttpMetricsNamesImpl         = copy(responses = name)
    def withResponsesErrors(name: String): HttpMetricsNamesImpl   = copy(responsesErrors = name)
    def withResponsesDuration(name: String): HttpMetricsNamesImpl = copy(responsesDuration = name)
    def withResponseSize(name: String): HttpMetricsNamesImpl      = copy(responsesSize = name)
    def withConnections(name: String): HttpMetricsNamesImpl       = copy(connections = name)
    def withConnectionsActive(name: String): HttpMetricsNamesImpl = copy(connectionsActive = name)
  }

  def apply(config: Config): HttpMetricsNames = HttpMetricsNamesImpl(
    config.getString("requests"),
    config.getString("requests-active"),
    config.getString("requests-size"),
    config.getString("responses"),
    config.getString("responses-errors"),
    config.getString("responses-duration"),
    config.getString("responses-size"),
    config.getString("connections"),
    config.getString("connections-active")
  )
}
