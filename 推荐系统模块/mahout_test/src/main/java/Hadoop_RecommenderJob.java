import org.apache.mahout.cf.taste.hadoop.item.RecommenderJob;

public class Hadoop_RecommenderJob {

    public static void main(String[] args) throws Exception {
        String[] arg=new String[]{"-jt","hadoop1:9001","-fs","hadoop1:9000",
                "--input","hdfs://hadoop1:9000/recommend/input/user_item",//包含一个或多个带有首选项数据的文本文件的目录
                "--output","hdfs://hadoop1:9000/recommend/output/",//推荐器输出的输出路径
                "--similarityClassname","org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.PearsonCorrelationSimilarity",//要实例化的矢量相似度类的名称或来自的预定义相似度
                "--numRecommendations","20",//每个用户计算的推荐数（10）
                "--booleanData","false",//将输入数据视为没有pref值（false）
                "--maxPrefsPerUser","7",//最终推荐阶段每个用户考虑的最大偏好数（10）
                "--minPrefsPerUser","2",//在相似度计算中忽略优先级低于此的用户（1）
                "--maxPrefsInItemSimilarity","50",//在项目相似度计算阶段中每个用户要考虑的最大偏好数，具有更多偏好的用户将被向下采样（1000）
                "--tempDir","hdfs://hadoop1:9000/recommend/temp"};//临时文件路径

        RecommenderJob.main(arg);

    }

}
