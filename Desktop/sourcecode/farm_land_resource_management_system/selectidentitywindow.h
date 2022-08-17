#ifndef SELECTIDENTITYWINDOW_H
#define SELECTIDENTITYWINDOW_H

#include <QWidget>

namespace Ui {
class SelectIdentityWindow;
}

class SelectIdentityWindow : public QWidget
{
    Q_OBJECT

public:
    explicit SelectIdentityWindow(QWidget *parent = nullptr);
    ~SelectIdentityWindow();

private:
    Ui::SelectIdentityWindow *ui;
};

#endif // SELECTIDENTITYWINDOW_H
