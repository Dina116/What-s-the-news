package com.training.whatsthenews;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<NewsTable> __deletionAdapterOfNewsTable;

  private final EntityUpsertionAdapter<NewsTable> __upsertionAdapterOfNewsTable;

  public NewsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__deletionAdapterOfNewsTable = new EntityDeletionOrUpdateAdapter<NewsTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `news_table` WHERE `_id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NewsTable entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__upsertionAdapterOfNewsTable = new EntityUpsertionAdapter<NewsTable>(new EntityInsertionAdapter<NewsTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `news_table` (`_id`,`title`,`uniformResourceLocator`,`urlToImage`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NewsTable entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getUniformResourceLocator());
        statement.bindString(4, entity.getUrlToImage());
      }
    }, new EntityDeletionOrUpdateAdapter<NewsTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `news_table` SET `_id` = ?,`title` = ?,`uniformResourceLocator` = ?,`urlToImage` = ? WHERE `_id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NewsTable entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getUniformResourceLocator());
        statement.bindString(4, entity.getUrlToImage());
        statement.bindLong(5, entity.getId());
      }
    });
  }

  @Override
  public Object deleteAll(final NewsTable article, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNewsTable.handle(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsert(final NewsTable article, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfNewsTable.upsert(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<NewsTable>> getData() {
    final String _sql = "SELECT * FROM news_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"news_table"}, false, new Callable<List<NewsTable>>() {
      @Override
      @Nullable
      public List<NewsTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUniformResourceLocator = CursorUtil.getColumnIndexOrThrow(_cursor, "uniformResourceLocator");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final List<NewsTable> _result = new ArrayList<NewsTable>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NewsTable _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUniformResourceLocator;
            _tmpUniformResourceLocator = _cursor.getString(_cursorIndexOfUniformResourceLocator);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            _item = new NewsTable(_tmpId,_tmpTitle,_tmpUniformResourceLocator,_tmpUrlToImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
