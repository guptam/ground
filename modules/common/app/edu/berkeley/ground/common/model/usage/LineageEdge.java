/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.berkeley.ground.common.model.usage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.berkeley.ground.common.model.version.Item;
import edu.berkeley.ground.common.model.version.Tag;
import java.util.Map;

public class LineageEdge extends Item {

  // the name of this LineageEdge
  @JsonProperty("name")
  private final String name;

  // the source key for this Node
  @JsonProperty("sourceKey")
  private final String sourceKey;

  /**
   * Create a new lineage edge.
   *
   * @param id the id of the lineage edge
   * @param name the name of the lineage edge
   * @param sourceKey the user-generated unique key for the lineage edge
   * @param tags the tags associated with this lineage edge
   */

  @JsonCreator
  public LineageEdge(@JsonProperty("itemId") long id, @JsonProperty("name") String name,
                      @JsonProperty("sourceKey") String sourceKey, @JsonProperty("tags") Map<String, Tag> tags) {
    super(id, tags);

    this.name = name;
    this.sourceKey = sourceKey;
  }

  public LineageEdge(long id, LineageEdge other) {
    super(id, other.getTags());

    this.name = other.name;
    this.sourceKey = other.sourceKey;
  }

  public String getName() {
    return this.name;
  }

  public String getSourceKey() {
    return this.sourceKey;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof LineageEdge)) {
      return false;
    }

    LineageEdge otherLineageEdge = (LineageEdge) other;

    return this.name.equals(otherLineageEdge.name)
             && this.getId() == otherLineageEdge.getId()
             && this.sourceKey.equals(otherLineageEdge.sourceKey)
             && this.getTags().equals(otherLineageEdge.getTags());
  }
}
