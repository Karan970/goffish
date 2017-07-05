package in.dream_lab.goffish.hama;

import in.dream_lab.goffish.api.IBiVertex;
import in.dream_lab.goffish.api.IEdge;
import org.apache.hadoop.io.Writable;

import java.util.Collection;
import java.util.List;

/**
 * Created by hduser on 30/6/17.
 */
public class Bivertex<V extends Writable, E extends Writable, I extends Writable, J extends Writable> extends Vertex implements IBiVertex<V , E, I, J>  {
    private List<IEdge<E, I, J>> _adjList;
    private List<IEdge<E, I, J>> _inadjList;


    @Override
    public I getVertexId() {
        return null;
    }

    @Override
    public boolean isRemote() {
        return false;
    }

    @Override
    public Collection<IEdge> getOutEdges() {
        return null;
    }

    @Override
    public Collection<IEdge> getInEdges() {
        return null;
    }

    @Override
    public J getValue() {
        return null;
    }

    @Override
    public void setValue(Writable value) {

    }
}
