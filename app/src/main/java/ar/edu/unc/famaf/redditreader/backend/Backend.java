package ar.edu.unc.famaf.redditreader.backend;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unc.famaf.redditreader.R;
import ar.edu.unc.famaf.redditreader.model.PostModel;

public class Backend {
    private static Backend ourInstance = new Backend();

    public static Backend getInstance() {
        return ourInstance;
    }

    private Backend() {
    }

    public List<PostModel> getTopPosts() {
        List<PostModel> postModelsList = new ArrayList<>();

        PostModel postModel1 = new PostModel();
        postModel1.setTitle("Este es el titulo numero 1");
        postModel1.setAuthor("r/author1");
        postModel1.setDate("Hace 1 hora");
        postModel1.setComments(10);
        postModel1.setPreviewId(R.drawable.reddit_icon);

        PostModel postModel2 = new PostModel();
        postModel2.setTitle("Este es el titulo numero 2");
        postModel2.setAuthor("r/author2");
        postModel2.setDate("Hace 2 horas");
        postModel2.setComments(20);
        postModel2.setPreviewId(R.drawable.reddit_icon);

        PostModel postModel3 = new PostModel();
        postModel3.setTitle("Este es el titulo numero 3");
        postModel3.setAuthor("r/author3");
        postModel3.setDate("Hace 3 horas");
        postModel3.setComments(30);
        postModel3.setPreviewId(R.drawable.reddit_icon);

        PostModel postModel4 = new PostModel();
        postModel4.setTitle("Este es el titulo numero 4");
        postModel4.setAuthor("r/author4");
        postModel4.setDate("Hace 4 horas");
        postModel4.setComments(40);
        postModel4.setPreviewId(R.drawable.reddit_icon);

        PostModel postModel5 = new PostModel();
        postModel5.setTitle("Este es el titulo numero 5");
        postModel5.setAuthor("r/author5");
        postModel5.setDate("Hace 5 horas");
        postModel5.setComments(50);
        postModel5.setPreviewId(R.drawable.reddit_icon);

        postModelsList.add(postModel1);
        postModelsList.add(postModel2);
        postModelsList.add(postModel3);
        postModelsList.add(postModel4);
        postModelsList.add(postModel5);

        return postModelsList;
    }
}
