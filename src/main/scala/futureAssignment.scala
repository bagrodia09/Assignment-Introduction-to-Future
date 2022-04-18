import java.nio.file.{FileSystems, Files}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.jdk.CollectionConverters.IteratorHasAsScala
import scala.language.postfixOps
class futureAssignment(path:String){
  def contentOfDirectory(path:String):Future[List[String]]=Future{
    Thread.sleep(1000)
    val temp = FileSystems.getDefault.getPath(path)
    if(temp.toFile.isDirectory || temp.toFile.exists()) {
      List(Files.walk(temp).iterator().asScala.foreach(println).toString)
    }
    else{
      List("This path is invalid")
    }
  }
  val receivedPath: List[String] = Await.result(contentOfDirectory(path) ,1 second)
}