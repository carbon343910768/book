import org.apache.mahout.clustering.kmeans.KMeansDriver;

public class Hadoop_KMeansDriver {
    public static void main(String[] args) throws Exception {
        String[] arg=new String[]{"-jt","hadoop1:9001","-fs","hadoop1:9000",//namenode和作业tracker
                "--input","hdfs://hadoop1:9000/kmeans/input/user_item",//输入点的目录路径名
                "--output","hdfs://hadoop1:9000/kmeans/output/",//推荐器输出的输出路径
                "--distanceMeasure","org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.CosineSimilarity",//数据点间的距离计算方法
                "--clusters","hdfs://hadoop1:9000/kmeans/clusters/",//初始和计算集群的目录路径名
                //"--numClusters","10",//簇的个数
                "--convergenceDelta","0.001",//收敛delta值
                "--maxIter","5000",//最大迭代次数
                "--tempDir","hdfs://hadoop1:9000/kmeans/temp"};//临时文件路径

        KMeansDriver.main(arg);
        //KMeansDriver.run();

    }
}
