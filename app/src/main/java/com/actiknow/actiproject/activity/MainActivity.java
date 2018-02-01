package com.actiknow.actiproject.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.actiknow.actiproject.R;
import com.actiknow.actiproject.utils.SetTypeFace;
import com.actiknow.actiproject.utils.UserDetailsPref;
import com.actiknow.actiproject.utils.Utils;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mikepenz.materialdrawer.util.DrawerUIUtils;

public class MainActivity extends AppCompatActivity {
    private AccountHeader headerResult = null;
    private Drawer result = null;
    public static final int REQUEST_LOGIN_SCREEN_RESULT = 2;
    UserDetailsPref userDetailsPref;
    CoordinatorLayout clMain;
    ProgressDialog progressDialog;
    ImageView ivNavigation;
    Bundle savedInstanceState;
    TextView tvHeading;
    TextView tvNewProject;
    TextView tvExistingProject;
    TextView tvNext;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    LinearLayout llNewProject;
    LinearLayout llExistingProject;

    String[] arraySpinner = new String[]{"Category 1", "Category 2", "Category 3", "Category 4"};
    String[] arraySpinner2 = new String[]{"Line 1", "Line 2", "Line 3", "Line 4"};
    String[] arraySpinner3 = new String[]{"Tonnage 1", "Tonnage 2", "Tonnage 3", "Tonnage 4"};
    String[] arraySpinner4 = new String[]{"Project Id 1", "Project Id 2", "Project Id 3", "Project Id 4"};
    String[] arraySpinner5 = new String[]{"Product Model 1", "Product Model 2", "Product Model 3", "Product Model 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
        initListener();
        isLogin();
        initDrawer();
    }

    private void initListener() {
        ivNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.openDrawer();

            }
        });
        tvNewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNewProject.setBackgroundResource(R.drawable.button_filled);
                tvExistingProject.setBackgroundResource(R.drawable.button_hollow);
                tvNewProject.setTextColor(getResources().getColor(R.color.text_color_white));
                tvExistingProject.setTextColor(getResources().getColor(R.color.primary));
                llNewProject.setVisibility(View.VISIBLE);
                llExistingProject.setVisibility(View.GONE);

            }
        });
        tvExistingProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNewProject.setBackgroundResource(R.drawable.button_hollow);
                tvExistingProject.setBackgroundResource(R.drawable.button_filled);
                tvNewProject.setTextColor(getResources().getColor(R.color.primary));
                tvExistingProject.setTextColor(getResources().getColor(R.color.text_color_white));
                llNewProject.setVisibility(View.GONE);
                llExistingProject.setVisibility(View.VISIBLE);

            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ProjectDetailActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("Select Product Category")
                        .items(arraySpinner)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                et1.setText(text);
                            }
                        })
                        .show();

            }
        });
        et2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("Select Product Line")
                        .items(arraySpinner2)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                et2.setText(text);
                            }
                        })
                        .show();

            }
        });
        et3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("Select Tonnage")
                        .items(arraySpinner3)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                et3.setText(text);
                            }
                        })
                        .show();
            }
        });
        et4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("Select Project ID")
                        .items(arraySpinner4)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                et4.setText(text);
                            }
                        })
                        .show();
            }
        });
        et5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("Select Product Model(s)")
                        .items(arraySpinner5)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                et5.setText(text);
                            }
                        })
                        .show();

            }
        });
    }

    private void isLogin() {
        userDetailsPref = UserDetailsPref.getInstance();
        if (userDetailsPref.getStringPref(MainActivity.this, UserDetailsPref.LOGIN_KEY).length() == 0) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        }
    }

    private void initView() {
        clMain = (CoordinatorLayout) findViewById(R.id.clMain);
        ivNavigation = (ImageView) findViewById(R.id.ivNavigation);
        tvHeading = (TextView) findViewById(R.id.tvHeading);
        tvNewProject = (TextView) findViewById(R.id.tvNewProject);
        tvExistingProject = (TextView) findViewById(R.id.tvExistingProject);
        tvNext = (TextView) findViewById(R.id.tvNext);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        llNewProject = (LinearLayout) findViewById(R.id.llNewProject);
        llExistingProject = (LinearLayout) findViewById(R.id.llExistProject);
    }
    private void initData() {
        userDetailsPref = UserDetailsPref.getInstance();
        progressDialog = new ProgressDialog(this);
        Utils.setTypefaceToAllViews(this, tvHeading);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initAdapter() {
    }

    private void initDrawer() {
        IProfile profile = new IProfile() {
            @Override
            public Object withName(String name) {
                return null;
            }

            @Override
            public StringHolder getName() {
                return null;
            }

            @Override
            public Object withEmail(String email) {
                return null;
            }

            @Override
            public StringHolder getEmail() {
                return null;
            }

            @Override
            public Object withIcon(Drawable icon) {
                return null;
            }

            @Override
            public Object withIcon(Bitmap bitmap) {
                return null;
            }

            @Override
            public Object withIcon(@DrawableRes int iconRes) {
                return null;
            }

            @Override
            public Object withIcon(String url) {
                return null;
            }

            @Override
            public Object withIcon(Uri uri) {
                return null;
            }

            @Override
            public Object withIcon(IIcon icon) {
                return null;
            }

            @Override
            public ImageHolder getIcon() {
                return null;
            }

            @Override
            public Object withSelectable(boolean selectable) {
                return null;
            }

            @Override
            public boolean isSelectable() {
                return false;
            }

            @Override
            public Object withIdentifier(long identifier) {
                return null;
            }

            @Override
            public long getIdentifier() {
                return 0;
            }
        };

        DrawerImageLoader.init(new AbstractDrawerImageLoader() {
            @Override
            public void set(ImageView imageView, Uri uri, Drawable placeholder) {
                if (uri != null) {
                    Glide.with(imageView.getContext()).load(uri).placeholder(placeholder).into(imageView);
                }
            }

            @Override
            public void cancel(ImageView imageView) {
                Glide.clear(imageView);
            }

            @Override
            public Drawable placeholder(Context ctx, String tag) {
                //define different placeholders for different imageView targets
                //default tags are accessible via the DrawerImageLoader.Tags
                //custom ones can be checked via string. see the CustomUrlBasePrimaryDrawerItem LINE 111
                if (DrawerImageLoader.Tags.PROFILE.name().equals(tag)) {
                    return DrawerUIUtils.getPlaceHolder(ctx);
                } else if (DrawerImageLoader.Tags.ACCOUNT_HEADER.name().equals(tag)) {
                    return new IconicsDrawable(ctx).iconText(" ").backgroundColorRes(com.mikepenz.materialdrawer.R.color.colorPrimary).sizeDp(56);
                } else if ("customUrlItem".equals(tag)) {
                    return new IconicsDrawable(ctx).iconText(" ").backgroundColorRes(R.color.md_white_1000);
                }

                //we use the default one for
                //DrawerImageLoader.Tags.PROFILE_DRAWER_ITEM.name()

                return super.placeholder(ctx, tag);
            }
        });


        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(true)
                .withTypeface(SetTypeFace.getTypeface(MainActivity.this))
                .withTypeface(SetTypeFace.getTypeface(this))
                .withPaddingBelowHeader(false)
                .withSelectionListEnabled(false)
                .withSelectionListEnabledForSingleProfile(false)
                .withProfileImagesVisible(false)
                .withOnlyMainProfileImageVisible(true)
                .withDividerBelowHeader(true)
                .withProfileImagesClickable(false)
                .withHeaderBackground(R.color.primary)
                .withSavedInstance(savedInstanceState)
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        return false;
                    }
                })
                .build();
        headerResult.addProfiles(new ProfileDrawerItem()
                .withName(userDetailsPref.getStringPref(MainActivity.this, UserDetailsPref.NAME))

                .withEmail(userDetailsPref.getStringPref(MainActivity.this, UserDetailsPref.EMAIL)));


        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)

//                .withToolbar (toolbar)
//                .withItemAnimator (new AlphaCrossFadeAnimator ())
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Dashboard").withIcon(FontAwesome.Icon.faw_tachometer).withIdentifier(1).withTypeface(SetTypeFace.getTypeface(MainActivity.this)).withSelectable(false),
                        // new PrimaryDrawerItem().withName("Accepted").withIcon(FontAwesome.Icon.faw_arrow_circle_right).withIdentifier(2).withSelectable(false).withTypeface(SetTypeFace.getTypeface(MainActivity.this)),
                        // new PrimaryDrawerItem().withName("Rejected").withIcon(FontAwesome.Icon.faw_arrow_circle_left).withIdentifier(3).withSelectable(false).withTypeface(SetTypeFace.getTypeface(MainActivity.this)),
                        new PrimaryDrawerItem().withName("Sign Out").withIcon(FontAwesome.Icon.faw_sign_out).withIdentifier(4).withSelectable(false).withTypeface(SetTypeFace.getTypeface(MainActivity.this))

                )
                .withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 2:
                                Intent intent2 = new Intent(MainActivity.this, ProjectDetailActivity.class);
                                startActivity(intent2);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                break;
                            case 4:
                                showLogOutDialog();
                                break;
                        }
                        return false;
                    }
                })
                .build();
//        result.getActionBarDrawerToggle ().setDrawerIndicatorEnabled (false);
    }

    private void showLogOutDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .limitIconToDefaultSize()
                .content("Do you wish to Sign Out?")
                .positiveText("Yes")
                .negativeText("No")
                .typeface(SetTypeFace.getTypeface(MainActivity.this), SetTypeFace.getTypeface(MainActivity.this))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        userDetailsPref.putStringPref(MainActivity.this, UserDetailsPref.NAME, "");
                        userDetailsPref.putStringPref(MainActivity.this, UserDetailsPref.ID, "");
                        userDetailsPref.putStringPref(MainActivity.this, UserDetailsPref.EMAIL, "");
                        userDetailsPref.putStringPref(MainActivity.this, UserDetailsPref.LOGIN_KEY, "");
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    }
                }).build();
        dialog.show();
    }

    private void dialog(String[] arraySpinner, String s) {
    }


}
