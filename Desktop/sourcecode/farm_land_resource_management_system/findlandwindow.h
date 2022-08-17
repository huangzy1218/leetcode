#ifndef FINDLANDWINDOW_H
#define FINDLANDWINDOW_H

#include <QWidget>

namespace Ui {
class FindLandWindow;
}

class FindLandWindow : public QWidget
{
    Q_OBJECT

public:
    explicit FindLandWindow(QWidget *parent = nullptr);
    ~FindLandWindow();

private:
    Ui::FindLandWindow *ui;
};

#endif // FINDLANDWINDOW_H
