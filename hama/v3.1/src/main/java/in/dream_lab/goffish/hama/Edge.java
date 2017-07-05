
        package in.dream_lab.goffish.hama;
        import org.apache.hadoop.io.Writable;


        import org.apache.hadoop.io.LongWritable;
        import org.apache.hadoop.io.Writable;

        import in.dream_lab.goffish.api.IEdge;

public class Edge<E extends Writable, I extends Writable, J extends Writable>
        implements IEdge<E, I, J> {

  private Writable _source;
  private E _value;
  private J edgeID;
  private I _sink;

  public Edge(J id, I sinkID) {
    edgeID = id;
    _sink = sinkID;
  }

  public Edge(Writable sourceID, J id, I sinkID) {
    this(id,sinkID);
    _source = sourceID;
  }

  void setSinkID(I sinkID) {
    _sink = sinkID;
  }

  @Override
  public E getValue() {
    return _value;
  }

  @Override
  public void setValue(E val) {
    _value = val;
  }

  @Override
  public Writable getSourceVertexId() {
    return _source;
  }

  @Override
  public J getEdgeId() {
    return edgeID;
  }

  @Override
  public I getSinkVertexId() {
    return _sink;
  }
}


