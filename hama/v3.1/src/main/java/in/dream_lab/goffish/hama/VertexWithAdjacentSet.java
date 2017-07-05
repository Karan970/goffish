/**
 *  Copyright 2017 DREAM:Lab, Indian Institute of Science, Bangalore
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may
 *  not use this file except in compliance with the License. You may obtain
 *  a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  @author Himanshu Sharma
 *  @author Diptanshu Kakwani
 */

package in.dream_lab.goffish.hama;

import in.dream_lab.goffish.api.IEdge;
import in.dream_lab.goffish.api.IVertex;
import org.apache.hadoop.io.Writable;

import java.util.*;

public abstract class VertexWithAdjacentSet<V extends Writable, E extends Writable, I extends Writable, J extends Writable>
        implements IVertex<V, E, I, J> {

  private Map<I, IEdge<E, I, J>> _adjSet;
  private I vertexID;
  private V _value;

  VertexWithAdjacentSet() {
    _adjSet = new HashMap<I, IEdge<E, I, J>>();
  }

  VertexWithAdjacentSet(I ID) {
    this();
    vertexID = ID;
  }

  VertexWithAdjacentSet(I Id, Iterable<IEdge<E, I, J>> edges) {
    this(Id);
    for (IEdge<E, I, J> e : edges)
      _adjSet.put(e.getSinkVertexId(), e);
  }

  void setVertexID(I vertexID) {
    this.vertexID = vertexID;
  }

  @Override
  public I getVertexId() {
    return vertexID;
  }

  @Override
  public boolean isRemote() {
    return false;
  }

  @Override
  public Iterable<IEdge<E, I, J>> getOutEdges() {
    return _adjSet.values();
  }

  @Override
  public IEdge<E, I, J> getOutEdge(I vertexID) {
    return _adjSet.get(vertexID);
  }

  @Override
  public V getValue() {
    return _value;
  }

  @Override
  public void setValue(V value) {
    _value = value;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object o) {
    return this.vertexID == ((IVertex) o).getVertexId();
  }
}