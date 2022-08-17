#ifndef ENTERKEYWINDOW_H
#define ENTERKEYWINDOW_H

#include <QWidget>

namespace Ui {
class EnterKeyWindow;
}

class EnterKeyWindow : public QWidget
{
    Q_OBJECT

public:
    explicit EnterKeyWindow(QWidget *parent = nullptr);
    ~EnterKeyWindow();

private:
    Ui::EnterKeyWindow *ui;
};

#endif // ENTERKEYWINDOW_H
