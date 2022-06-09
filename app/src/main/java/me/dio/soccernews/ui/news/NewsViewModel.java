package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public final class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;



    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        //TODO Remover Mock
        List<News> news = new ArrayList<>();
        news.add(new News("Sport Campeão","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit"));
        news.add(new News("Sport joga domingo","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit"));
        news.add(new News("Copa do  mundo Volei ","Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit"));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews(){
        return news;
    }
}