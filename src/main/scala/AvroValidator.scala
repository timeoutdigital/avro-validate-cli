import java.io.File
import java.nio.file.Files

import scala.collection.JavaConverters._
import org.apache.avro.SchemaCompatibility.SchemaCompatibilityType._
import org.apache.avro.SchemaCompatibility._
import org.apache.avro.Schema


object AvroValidator extends App {

  def parse(file: File): Schema =
    new Schema.Parser().parse(file)

  def fileStatus(f: File) =
    if (!f.exists) s"${f.getAbsolutePath} does not exist" else ""

  def read(f: File): String =
    Files.readAllLines(f.toPath).asScala.mkString

  def validate(schema1: File, schema2: File) =
    checkReaderWriterCompatibility(parse(schema2), parse(schema1)).getType match {
      case COMPATIBLE => s"\033[32mdata written with ${schema1.getName} can always be read by ${schema2.getName}\033[0m"
      case _ => s"\033[31mdata written with ${schema1.getName} can NOT always be read by ${schema2.getName}\033[0m"
    }

  args.toList.map(new File(_)) match {
    case List(s1, s2) if s1.exists && s2.exists => println(validate(s1, s2))
    case l@List(_, _) => println(l.map(fileStatus).mkString(" and "))
    case _ => println("Usage: validate (schema 1) (schema 2)")
  }
}
