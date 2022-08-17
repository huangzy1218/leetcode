#ifndef ADDLANDWINDOW_H
#define ADDLANDWINDOW_H

#include <QWidget>

namespace Ui {
class AddLandWindow;
}

class AddLandWindow : public QWidget
{
    Q_OBJECT

public:
    explicit AddLandWindow(QWidget *parent = nullptr);
    ~AddLandWindow();

private:
    Ui::AddLandWindow *ui;
};

#endif // ADDLANDWINDOW_H
