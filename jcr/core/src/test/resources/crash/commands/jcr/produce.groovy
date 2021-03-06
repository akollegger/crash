import org.crsh.command.InvocationContext
import org.crsh.cmdline.annotations.Command
import org.crsh.cmdline.annotations.Usage
import org.crsh.jcr.command.Path
import org.crsh.cmdline.annotations.Argument;
import javax.jcr.Node;

public class produce extends org.crsh.command.CRaSHCommand  {

  @Command
  @Usage("produce a set of nodes")
  public void main(
    InvocationContext<Node> context,
    @Argument @Usage("the paths") List<Path> paths) {
    assertConnected();
    paths.each {
      try {
        def node = getNodeByPath(it)
        context.provide(node);
      }
      catch (Throwable t) {
        t.printStackTrace();
      }
    }
  }
}