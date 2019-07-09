import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.similarity.precompute.example.GroupLensDataModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Single_BaseItemRecommender {
    public static void main(String[] args) throws Exception {
        //准备数据 这里是评分数据
        File file = new File("C:\\Users\\MSI\\Desktop\\123.csv");
        //将数据加载到内存中
        DataModel dataModel = new FileDataModel(file);
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        ItemSimilarity itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        //UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);

        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
        Recommender recommender1 = new GenericItemBasedRecommender(dataModel, itemSimilarity);

        //UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(50, userSimilarity, dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
        //Recommender recommender1 = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);

        //给用户ID等于5的用户推荐10个与2398相似的商品
//        List<RecommendedItem> recommendedItemList = recommender.recommendedBecause(101, 200210, 10);
          List<RecommendedItem> recommendedItemList = recommender1.recommend(1, 10);
//
//        //recommender.
//        //打印推荐的结果
//        System.out.println("使用基于物品的协同过滤算法");
//        System.out.println("根据用户105当前浏览的商品20008，推荐10个相似的商品");
//        for (RecommendedItem recommendedItem : recommendedItemList) {
//            System.out.println(recommendedItem);
//
//        }
//        long start = System.currentTimeMillis();

        //File f1 = new File("ItemCF_item_simi_179.csv");
        File f1 = new File("UserCF_item_simi_179.csv");
        FileOutputStream fop1 = new FileOutputStream(f1);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer1 = new OutputStreamWriter(fop1, "UTF-8");


        List<Long> itemList = new LinkedList<Long>();
        LongPrimitiveIterator itemIterator = dataModel.getItemIDs();
        while (itemIterator.hasNext())
        {
            itemList.add(itemIterator.nextLong());
        }
        Iterator<Long> itit = itemList.listIterator();
        //Iterator<Long> tmp_it1 = itemList.listIterator();
        //Long first_item = itit.next();
        while (itit.hasNext())
        {
            Long next_item = itit.next();
            Iterator<Long> tmp_it = itemList.listIterator( 0);
            while (tmp_it.hasNext())
            {
                Long second_item = tmp_it.next();
                Double item_simi = itemSimilarity.itemSimilarity(next_item,second_item);
                //System.out.println(item_simi);
                String one_line = next_item.toString()+','+second_item.toString()+','+item_simi.toString()+"\n";
                if(!item_simi.isNaN())
                {
                    writer1.write(one_line);
                }

            }
        }

        writer1.close();
        fop1.close();

        File f2 = new File("UserCF_recommend_result_179.csv");
        FileOutputStream fop2 = new FileOutputStream(f2);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer2 = new OutputStreamWriter(fop2, "UTF-8");

        LongPrimitiveIterator userIterator = dataModel.getUserIDs();
        List<Long> userList = new LinkedList<Long>();
        while (userIterator.hasNext())
        {
           userList.add(userIterator.nextLong());
        }

        Iterator<Long> usit = userList.listIterator();

        while(usit.hasNext())
        {
            Long next_user = usit.next();
            Iterator<RecommendedItem> tmp_it = recommender1.recommend(next_user,20).listIterator();
            while (tmp_it.hasNext())
            {
                RecommendedItem tmp_item = tmp_it.next();
                Long recommend_item = tmp_item.getItemID();
                Float recommend_value = tmp_item.getValue();

                String one_line = next_user.toString()+','+recommend_item.toString()+','+recommend_value.toString()+"\n";

                writer2.write(one_line);

            }

        }

        writer2.close();
        fop2.close();

//        recommender.refresh(null);
//
//        recommendedItemList = recommender.recommendedBecause(105, 20008, 10);
//        //打印推荐的结果
//        System.out.println("使用基于物品的协同过滤算法");
//        System.out.println("根据用户5当前浏览的商品34，推荐10个相似的商品");
//        for (RecommendedItem recommendedItem : recommendedItemList) {
//            System.out.println(recommendedItem);
//        }
//        System.out.println(System.currentTimeMillis() -start);
    }
}